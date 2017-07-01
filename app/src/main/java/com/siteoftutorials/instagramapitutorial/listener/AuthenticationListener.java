package com.siteoftutorials.instagramapitutorial.listener;

/**
 * Created by torzsacristian on 29/06/2017.
 */

public interface AuthenticationListener {

    void onCodeReceived(String auth_token);

}
