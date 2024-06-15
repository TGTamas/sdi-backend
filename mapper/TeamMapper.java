package com.example.demo.mapper;

import com.example.demo.dto.DriverTeamDTO;
import com.example.demo.dto.TeamDetailsDTO;
import com.example.demo.dto.TeamListItemDTO;
import com.example.demo.models.Team;

public class TeamMapper {
    public static DriverTeamDTO toDriverTeamDTO(Team team){
        return DriverTeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }

    public static TeamDetailsDTO toDetails(Team team){
        return TeamDetailsDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .nationality(team.getNationality())
                .engine(team.getEngine())
                .foundationYear(team.getFoundationYear())
                .principal(team.getPrincipal())
                .drivers(DriverMapper.toTeamDriverDTO(team.getDrivers()))
                .build();
    }

    public static TeamListItemDTO toListItem(Team team){
        return TeamListItemDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .engine(team.getEngine())
                .principal(team.getPrincipal())
                .drivers(DriverMapper.toTeamDriverListDTO(team.getDrivers()))
                .build();
    }
}
