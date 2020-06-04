package com.challenge.mappers;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    @Mappings({
            @Mapping(source = "id.user.id", target = "userId"),
            @Mapping(source = "id.acceleration.id", target = "accelerationId"),
            @Mapping(source = "id.company.id", target = "companyId"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "status", target = "status")
    })
    CandidateDTO map(Candidate candidate);

    List<CandidateDTO> map(List<Candidate> candidates);


}
