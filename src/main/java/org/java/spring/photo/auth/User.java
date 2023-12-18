package org.java.spring.photo.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.java.spring.photo.pojo.Photo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	private String username;
	private String password;
	
//	Constructors
	public User(){}
	public User(String Username, String password, Role... roles) {
		setPassword(password);
		setUsername(Username);
		setRoles(roles);
	}

//	Relations
	@ManyToMany
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user")
    private List<Photo> photos = new ArrayList<>();
	
//	Getters & Setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	private void setRoles(Role... roles) {setRoles(List.of(roles));}
	public List<Role> getRoles() {return roles;}
	public void setRoles(List<Role> roles) {this.roles = roles;}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return 
				getRoles()
				.stream()
				.map(r -> new SimpleGrantedAuthority(r.getName()))
				.toList();
		}
	@Override
	public boolean isAccountNonExpired() {return true;}
	@Override
	public boolean isAccountNonLocked() {return true;}
	@Override
	public boolean isCredentialsNonExpired() {return true;}
	@Override
	public boolean isEnabled() {return true;}
	
}
