package dataBase

data class Person(var firstName: String, var lastName: String) {
    override fun toString(): String {
        return "$firstName $lastName"
    }
}

sealed class Contact {
    data class Phone(var number: String) : Contact() {
        override fun toString(): String {
            return number
        }
    }

    data class Email(var email: String) : Contact() {
        override fun toString(): String {
            return email
        }
    }

    data class Address(var index: String, var city: String, var street: String, var house: String) : Contact() {
        override fun toString(): String {
            return "$index, $city, $street, $house"
        }
    }

    data class DateOfBirth(var day: Int, var month: Int, var year: Int) : Contact() {
        override fun toString(): String {
            return "$day/$month/$year"
        }
    }
}