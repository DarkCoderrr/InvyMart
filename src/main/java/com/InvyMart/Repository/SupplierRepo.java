package com.InvyMart.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InvyMart.Model.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

	Optional<Supplier> findSupplierBysupplierId(long supplierId);
	
	Optional<Supplier> findSupplierByuserName(String username);
	
	@Transactional
	@Query(value="SELECT COUNT(1) FROM supplier WHERE user_name = :username AND password = :password", nativeQuery = true)
	Long isSupplierExistByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
