package com.PigeonSkyRace.PigeonSkyRace.model;

import com.PigeonSkyRace.PigeonSkyRace.enums.UserRoles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private UserRoles role = UserRoles.ROLE_USER;
    private boolean isEnabled = true;
}
