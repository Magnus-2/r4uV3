package com.r4u.security.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Here are all User details which you need for the Login
 * Registration and Authentication
 */
public class UserPrincipal implements UserDetails {


	private User user;

	/**
	 * Returns a User with all Details
	 * @param user
	 */
	public UserPrincipal(User user) {
		this.user = user;
	}

	/**
	 * Gives back the Authorities which a user have
	 * @return
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getDescription()));
        }
        return authorities;

        //return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

	/**
	 * Gives back the Password of a user
	 * @return
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/**
	 * Gives back the Username
	 * In the Login it`s the email
	 * @return
	 */
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	/**
	 * Gives back the User Id
	 * @return
	 */
	public Integer getId() {
		return user.getId();
	}

	/**
	 * Checks if the Account is existing
	 * @return
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Check if the Account is not locket
	 * @return
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if the credentials of a User are not expired
	 * @return
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if the Account is Enabled
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
