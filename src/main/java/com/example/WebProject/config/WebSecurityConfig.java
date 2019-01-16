package com.example.WebProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.WebProject.service.UserDetailsServiceImpl;;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Sét đặt dịch vụ để tìm kiếm User trong Database.
		// Và sét đặt PasswordEncoder.
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Các yêu cầu phải login với vai trò ROLE_EMPLOYEE hoặc ROLE_MANAGER.
		// Nếu chưa login, nó sẽ redirect tới trang /admin/login.
		http.authorizeRequests().antMatchers("/adaccessory/{id}/edit", "/adaccessory/save"
				,"/adaccessory/create", "/adaccessory/savecreate", "/adcustomer"
				, "/adcustomer/{id}/edit","/adcustomer/save", "/adcustomer/create", "/adcart",
				"/adcartView/{id}", "/adcartConfirm/{id}", "/adcartPaid/{id}", "/adcartline/{id}",
				"/adcartline/{id}/{id2}/delete", "/addrum/{id}/edit","/addrum/save", "/addrum/create",
				"/addrum/savecreate", "/adflute/{id}/edit", "/adflute/save", "/adflute/create",
				 "/adflute/savecreate","/admin", "/adguitar/{id}/edit", "/adguitar/savecreate", 
				"/adguitar/save", "/adguitar/create", "/adproducerGt/{idpr}", "/adproducer/{id}/edit",
				"/adproducer/{fil}/create", "/adproducer/save", "/adcolor", "/adcolor/{id}/edit", 
				"/adcolor/create", "/adcolor/save", "/adpiano/{id}/edit", "/adpiano/save", "/adpiano/create",
				"/adpiano/savecreate", "/adukulele/{id}/edit", "/adukulele/save", "/adukulele/create", "/adukulele/savecreate",
				"/notifycomment", "/seencomment/{id}", 
				"/_", "/_guitar", "/_piano", "/_ukulele", "/_drum", "/_flute", "/_accessory", "/_product/{id}", "/adcomment/{id}/delete"
				,"/adaccessory", "/addrum", "/adflute", "/adguitar", "/adpiano", "/adukulele")//
				.access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");

		// Các trang chỉ dành cho MANAGER
		http.authorizeRequests().antMatchers("/adaccessory/{id}/delete", "/aduser", "/aduser/{id}/edit", 
				"/aduser/{id}/delete", "/aduser/create", "/aduser/save", "/adcustomer/{id}/delete"
				, "/adcart/{id}/delete", "/addrum/{id}/delete", "/adflute/{id}/delete","/adguitar/{id}/delete"
				,"/adproducer/{id}/delete/{idpr}", "/adcolor/{id}/delete", "/adpiano/{id}/delete",
				"/adukulele/{id}/delete").access("hasRole('ROLE_MANAGER')");

		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//

				// 
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/_")//
				.failureUrl("/login?error=true")//
				.usernameParameter("userName")//
				.passwordParameter("password")

				// Cấu hình cho trang Logout.
				// (Sau khi logout, chuyển tới trang home)
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

	}
}
