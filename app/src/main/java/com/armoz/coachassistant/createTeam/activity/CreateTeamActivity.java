package com.armoz.coachassistant.createTeam.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.armoz.coachassistant.R;
import com.armoz.coachassistant.base.activity.BaseActivity;
import com.armoz.coachassistant.createTeam.component.DaggerCreateTeamComponent;
import com.armoz.coachassistant.createTeam.module.CreateTeamModule;
import com.armoz.coachassistant.createTeam.presenter.CreateTeamPresenter;
import com.armoz.coachassistant.base.viewModel.TeamViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.armoz.coachassistant.base.viewModel.TeamViewModelBuilder.teamViewModel;

public class CreateTeamActivity extends BaseActivity implements CreateTeamPresenter.View {

    @Inject
    CreateTeamPresenter presenter;

    @BindView(R.id.createTeam_nameEditText)
    EditText nameInput;
    @BindView(R.id.createTeam_categoryEditText)
    EditText categoryInput;
    @BindView(R.id.createTeam_clubEditText)
    EditText clubInput;

    @BindView(R.id.createTeam_nameInput)
    TextInputLayout nameInputLayout;
    @BindView(R.id.createTeam_categoryInput)
    TextInputLayout categoryInputLayout;
    @BindView(R.id.createTeam_clubInput)
    TextInputLayout clubInputLayout;

    @BindView(R.id.createTeam_createButton)
    Button createTeamButton;

    public static Intent buildIntent(Context context) {
        return new Intent(context, CreateTeamActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        ButterKnife.bind(this);
        initializeInjector();
        presenter.setView(this);

        initTextWatchers();
    }

    private void initTextWatchers() {
        nameInput.addTextChangedListener(new InputStringTextWatcher(nameInput, nameInputLayout));
        categoryInput.addTextChangedListener(new InputStringTextWatcher(categoryInput, categoryInputLayout));
        clubInput.addTextChangedListener(new InputStringTextWatcher(clubInput, clubInputLayout));


        clubInputLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                createTeamButton.setText("focusChange");
            }
        });
    }

    @OnClick
    public void onCreateTeam() {
        String name = categoryInput.getText().toString();
        String category = categoryInput.getText().toString();
        String club = clubInput.getText().toString();

        TeamViewModel teamViewModel = teamViewModel()
                .setName(name)
                .setCategory(category)
                .setClub(club)
                .build();

        presenter.createTeam(teamViewModel);
    }


    public class InputStringTextWatcher implements TextWatcher {

        private EditText editText;
        private TextInputLayout textInputLayout;

        private InputStringTextWatcher(EditText editText, TextInputLayout textInputLayout) {
            this.editText = editText;
            this.textInputLayout = textInputLayout;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            if (editText.getText().toString().isEmpty()){
                textInputLayout.setError(getString(R.string.global_requiredField));
                if (editText.requestFocus()) {
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                    disableCreateTeamButton();
                }
            } else {
                textInputLayout.setErrorEnabled(false);
                checkCreateButtonState();
            }
        }
    }

    private void checkCreateButtonState() {
        if (nameInputLayout.getError() != null && !nameInput.getText().toString().isEmpty()
                && categoryInputLayout.getError() != null && !categoryInput.getText().toString().isEmpty()
                && clubInputLayout.getError() != null && !clubInput.getText().toString().isEmpty()) {
            createTeamButton.setEnabled(true);
        } else {
            createTeamButton.setEnabled(false);
        }
    }

    private void disableCreateTeamButton() {
        createTeamButton.setEnabled(false);
    }


    @Override
    public void onTeamCreated() {
        Intent intent = CreateTeamActivity.buildIntent(this);
        this.startActivity(intent);
    }

    private void initializeInjector() {
        DaggerCreateTeamComponent.builder()
                .applicationComponent(getApplicationComponent())
                .createTeamModule(new CreateTeamModule())
                .build()
                .inject(this);
    }
}
