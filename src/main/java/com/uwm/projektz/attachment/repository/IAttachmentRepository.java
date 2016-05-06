package com.uwm.projektz.attachment.repository;

import com.uwm.projektz.attachment.ob.AttachmentOB;
import com.uwm.projektz.user.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Repository
public interface IAttachmentRepository extends JpaRepository<AttachmentOB,Long> {
    @Query("SELECT a FROM AttachmentOB WHERE a.user.id = ?1")
    List<AttachmentOB> attachments (Long aUserID);
}
