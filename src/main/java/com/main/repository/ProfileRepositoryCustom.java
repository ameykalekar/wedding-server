/**
 * 
 */
package com.main.repository;

import java.util.List;

import com.main.entity.ProfileEntity;
import com.main.vo.ProfileVo;

/**
 * @author Sagar
 *
 */
public interface ProfileRepositoryCustom {
	
	List<ProfileEntity> searchProfile(ProfileVo  profileVo);
	
}
