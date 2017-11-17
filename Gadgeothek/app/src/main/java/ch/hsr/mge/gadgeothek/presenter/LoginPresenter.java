package ch.hsr.mge.gadgeothek.presenter;

/**
 * Created by s on 10/28/17.
 */

public class LoginPresenter implements LoginContract.UserActionsListener {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {

        this.view = view;
    }


    @Override
    public void setupView() {

        view.resetCredentials();
    }
}
