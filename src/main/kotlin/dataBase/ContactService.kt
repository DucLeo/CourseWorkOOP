package dataBase

interface ContactsServiceInterface {
    fun addContact(person: Person, contact: Contact)

    fun addPerson(person: Person)

    fun addPhone(person: Person, number: String)

    fun addEmail(person: Person, email: String)

    fun addAddress(person: Person, index: String, city: String, street: String, house: String)

    fun addDateOfBirth(person: Person, day: Int, month: Int, year: Int)

    fun removeContact(person: Person, contact: Contact)

    fun removeAllContactPerson(person: Person)

    fun removePerson(person: Person)

    fun getPersonContacts(person: Person): List<Contact>

    fun getPersonPhones(person: Person): List<Contact.Phone>

    fun getPersonEmails(person: Person): List<Contact.Email>?

    fun getPersonAddress(person: Person): List<Contact.Address>

    fun getPersonDateOfBirth(person: Person): List<Contact.DateOfBirth?>

    fun getAllPeople(): List<Person>
}


class ContactService : ContactsServiceInterface {

    private val mapContact: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addPerson(person: Person) {
        if (!mapContact.contains(person)) {
            mapContact[person] = mutableListOf()
        }
    }

    override fun addContact(person: Person, contact: Contact) {
        addPerson(person)
        mapContact[person]?.add(contact)
    }

    override fun addPhone(person: Person, number: String) {
        addContact(person, Contact.Phone(number))
    }

    override fun addEmail(person: Person, email: String) {
        addContact(person, Contact.Email(email))
    }

    override fun addAddress(person: Person, index: String, city: String, street: String, house: String) {
        addContact(person, Contact.Address(index, city, street, house))
    }

    override fun addDateOfBirth(person: Person, day: Int, month: Int, year: Int) {
        addContact(person, Contact.DateOfBirth(day, month, year))
    }

    override fun removeContact(person: Person, contact: Contact) {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            if (mapContact[person]?.contains(contact) == false) {
                error("$person does not have $contact!")
            } else {
                mapContact[person]?.remove(contact)
            }
        }
    }

    override fun removeAllContactPerson(person: Person) {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            mapContact[person]?.clear()
        }
    }

    override fun removePerson(person: Person) {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            mapContact.remove(person)
        }
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            return mapContact[person]?.toList() ?: emptyList()
        }
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            val listPhone: MutableList<Contact.Phone> = mutableListOf()
            mapContact[person]?.forEach {
                if (it is Contact.Phone) {
                    listPhone.add(it)
                }
            }
            return listPhone.toList()
        }
    }

    override fun getPersonEmails(person: Person): List<Contact.Email> {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            val listEmail: MutableList<Contact.Email> = mutableListOf()
            mapContact[person]?.forEach {
                if (it is Contact.Email) {
                    listEmail.add(it)
                }
            }
            return listEmail.toList()
        }
    }

    override fun getPersonAddress(person: Person): List<Contact.Address> {
        if (!mapContact.contains(person)) {
            error("$person is not exist!")
        } else {
            val listAddress: MutableList<Contact.Address> = mutableListOf()
            mapContact[person]?.forEach {
                if (it is Contact.Address) {
                    listAddress.add(it)
                }
            }
            return listAddress.toList()
        }
    }

    override fun getPersonDateOfBirth(person: Person): List<Contact.DateOfBirth> {
        if (!mapContact.keys.toList().contains(person)) {
            error("$person is not exist!")
        } else {
            val listBirthDay: MutableList<Contact.DateOfBirth> = mutableListOf()
            mapContact[person]?.forEach {
                if (it is Contact.DateOfBirth) {
                    listBirthDay.add(it)
                }
            }
            return listBirthDay.toList()
        }
    }

    override fun getAllPeople(): List<Person> {
        val listPerson: MutableList<Person> = mutableListOf()
        mapContact.keys.forEach {
            listPerson.add(it)
        }
        return listPerson
    }
}
