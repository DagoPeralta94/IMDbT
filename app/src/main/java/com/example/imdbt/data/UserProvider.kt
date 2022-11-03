package com.example.imdbt.data

import com.example.imdbt.data.model.UserData

class UserProvider {
    companion object {
        val userList = listOf<UserData>(
            UserData(
                "Dago",
                "dago123"
            ),
            UserData(
                "Diego",
                "diego123"
            ),
            UserData(
                "a",
                "a"
            )
        )
    }
}