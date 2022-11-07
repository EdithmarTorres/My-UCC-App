package com.example.myuccapp.Courses

data class User(var courseID: String ?= null,var courseName: String ?= null,
                var courseCredits: String ?= null,var coursePrerequisites: String ?= null,
                val courseDescription: String ?= null)


