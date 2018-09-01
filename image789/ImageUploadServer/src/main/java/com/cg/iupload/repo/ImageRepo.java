package com.cg.iupload.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.iupload.beans.ImageBean;
@Repository
public interface ImageRepo extends JpaRepository<ImageBean, Integer>{

	@Query(value="select i from ImageBean i where i.imgId=(:imgId)")
	ImageBean getImage(@Param(value="imgId")Integer imgId);

}
