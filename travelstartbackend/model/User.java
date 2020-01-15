package main.travelstartbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name ="User")
@Scope("session")
public class User implements UserDetails 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum Role{ USER }

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(name = "role")
    private String  role;
	
	
	public User() 
	{
		super();
	}

	public User(int id, String username, String firstName, String lastName, String password) 
	{
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}


	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() 
	{
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() 
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
				 ",]";
	}
}
