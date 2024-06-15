package com.example.demo.mapper;

import com.example.demo.dto.DriverDetailsDTO;
import com.example.demo.dto.DriverListItemDTO;
import com.example.demo.dto.TeamDriverDTO;
import com.example.demo.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverMapper {
    public static DriverDetailsDTO toDetails(Driver driver) {
        return DriverDetailsDTO.builder()
                .id(driver.getId())
                .age(driver.getAge())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .gender(driver.getGender())
                .nationality(driver.getNationality())
                .team(TeamMapper.toDriverTeamDTO(driver.getTeam()))
                .build();
    }

//    public static List<DriverListItemDTO> toList(List<Driver> drivers){
//        return drivers.stream()
//                .map(DriverMapper::toListItem)
//                .collect(Collectors.toList());
//    }

    public static List<DriverListItemDTO> toList(List<Driver> drivers){
        final List<DriverListItemDTO> list = new ArrayList<>(drivers.size());
        drivers.forEach(driver -> list.add(toListItem(driver)));
        return list;
    }

    public static List<TeamDriverDTO> toTeamDriverDTO(List<Driver> drivers){
        List<TeamDriverDTO> driverDTOS = new ArrayList<TeamDriverDTO>();
        for (Driver driver:drivers) {
            TeamDriverDTO driverDTO = TeamDriverDTO.builder()
                    .id(driver.getId())
                    .fullName(driver.getFirstName() + " " + driver.getLastName())
                    .build();
            driverDTOS.add(driverDTO);
        }
        return driverDTOS;
    }

    public static List<String> toTeamDriverListDTO(List<Driver> drivers){
        List<String> names = new ArrayList<String>();
        for (Driver driver:drivers) {
            String name = driver.getFirstName() + " " + driver.getLastName();
            names.add(name);
        }
        return names;
    }

    public static DriverListItemDTO toListItem(Driver driver) {
        return DriverListItemDTO.builder()
                .id(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .nationality(driver.getNationality())
                .teamName(driver.getTeam().getName())
                .build();
    }

}
