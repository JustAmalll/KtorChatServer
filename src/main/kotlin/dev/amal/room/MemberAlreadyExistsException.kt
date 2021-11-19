package dev.amal.room

import java.lang.Exception

class MemberAlreadyExistsException: Exception(
    "There is already a member with that username in the room."
)