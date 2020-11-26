package com.capg.fms.us.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.us.dto.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users,String>
{

}
