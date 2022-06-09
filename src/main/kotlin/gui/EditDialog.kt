package gui

import dataBase.Contact
import dataBase.ContactService
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class EditDialog constructor(phonebook: ContactService, i: Int) : JDialog(),
    ActionListener {
    private val textFirstName = JTextPane()
    private val textLastName = JTextPane()
    private val textPhone = JTextPane()
    private val textOtherPhone = JTextPane()
    private val textEmail = JTextPane()
    private val textOtherEmail = JTextPane()
    private val textIndex = JTextPane()
    private val textCity = JTextPane()
    private val textStreet = JTextPane()
    private val textHouse = JTextPane()
    private val textDay = JTextPane()
    private val textMonth = JTextPane()
    private val textYear = JTextPane()

    private var person = phonebook.getAllPeople()[i]

    var isSave = false
        private set

    init {
        layout = null
        title = "EDIT CONTACT"
        buildFields(phonebook)
        buildButtons()
        isModal = true
        isResizable = false
        setBounds(0, 0, 450, 340)
        isVisible = true
    }


    private fun buildFields(phonebook: ContactService) {

        val labelFirstName = JLabel("First name:")
        labelFirstName.horizontalAlignment = SwingConstants.LEFT
        labelFirstName.bounds = Rectangle(10, 10, 150, 25)
        add(labelFirstName)
        textFirstName.bounds = Rectangle(100, 10, 110, 25)
        textFirstName.border = BorderFactory.createEtchedBorder()
        textFirstName.text = person.firstName
        add(textFirstName)


        val labelLastName = JLabel("Last name:")
        labelLastName.horizontalAlignment = SwingConstants.LEFT
        labelLastName.bounds = Rectangle(215, 10, 250, 25)
        add(labelLastName)
        textLastName.bounds = Rectangle(280, 10, 140, 25)
        textLastName.border = BorderFactory.createEtchedBorder()
        textLastName.text = person.lastName
        add(textLastName)


        val labelPhone = JLabel("Phone number:")
        labelPhone.horizontalAlignment = SwingConstants.LEFT
        labelPhone.bounds = Rectangle(10, 130, 430, 25)
        add(labelPhone)
        textPhone.bounds = Rectangle(100, 130, 320, 25)
        textPhone.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonPhones(person).isNotEmpty()) {
            textPhone.text = phonebook.getPersonPhones(person)[0].toString()
        }
        add(textPhone)

        val labelOtherPhone = JLabel("Other number:")
        labelOtherPhone.horizontalAlignment = SwingConstants.LEFT
        labelOtherPhone.bounds = Rectangle(10, 160, 430, 25)
        add(labelOtherPhone)
        textOtherPhone.bounds = Rectangle(100, 160, 320, 25)
        textOtherPhone.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonPhones(person).size > 1) {
            textOtherPhone.text = phonebook.getPersonPhones(person)[1].toString()
        }
        add(textOtherPhone)


        val labelEmail = JLabel("Email:")
        labelEmail.horizontalAlignment = SwingConstants.LEFT
        labelEmail.bounds = Rectangle(10, 190, 430, 25)
        add(labelEmail)
        textEmail.bounds = Rectangle(100, 190, 320, 25)
        textEmail.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonEmails(person).isNotEmpty()) {
            textEmail.text = phonebook.getPersonEmails(person)[0].toString()
        }
        add(textEmail)


        val labelOtherEmail = JLabel("Other email:")
        labelOtherEmail.horizontalAlignment = SwingConstants.LEFT
        labelOtherEmail.bounds = Rectangle(10, 220, 430, 25)
        add(labelOtherEmail)
        textOtherEmail.bounds = Rectangle(100, 220, 320, 25)
        textOtherEmail.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonEmails(person).size > 1) {
            textOtherEmail.text = phonebook.getPersonEmails(person)[1].toString()
        }
        add(textOtherEmail)


        val labelIndex = JLabel("Index:")
        labelIndex.horizontalAlignment = SwingConstants.LEFT
        labelIndex.bounds = Rectangle(10, 70, 150, 25)
        add(labelIndex)
        textIndex.bounds = Rectangle(100, 70, 110, 25)
        textIndex.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonAddress(person).isNotEmpty()) {
            textIndex.text = phonebook.getPersonAddress(person)[0].index
        }
        add(textIndex)

        val labelCity = JLabel("City:")
        labelCity.horizontalAlignment = SwingConstants.LEFT
        labelCity.bounds = Rectangle(230, 70, 250, 25)
        add(labelCity)
        textCity.bounds = Rectangle(280, 70, 140, 25)
        textCity.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonAddress(person).isNotEmpty()) {
            textCity.text = phonebook.getPersonAddress(person)[0].city
        }
        add(textCity)

        val labelStreet = JLabel("Street:")
        labelStreet.horizontalAlignment = SwingConstants.LEFT
        labelStreet.bounds = Rectangle(10, 100, 150, 25)
        add(labelStreet)
        textStreet.bounds = Rectangle(100, 100, 110, 25)
        textStreet.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonAddress(person).isNotEmpty()) {
            textStreet.text = phonebook.getPersonAddress(person)[0].street
        }
        add(textStreet)

        val labelHouse = JLabel("House:")
        labelHouse.horizontalAlignment = SwingConstants.LEFT
        labelHouse.bounds = Rectangle(230, 100, 300, 25)
        add(labelHouse)
        textHouse.bounds = Rectangle(280, 100, 140, 25)
        textHouse.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonAddress(person).isNotEmpty()) {
            textHouse.text = phonebook.getPersonAddress(person)[0].house
        }
        add(textHouse)


        val labelBirthDay = JLabel("Date of birth:")
        labelBirthDay.horizontalAlignment = SwingConstants.LEFT
        labelBirthDay.bounds = Rectangle(10, 40, 250, 25)
        add(labelBirthDay)
        textDay.bounds = Rectangle(100, 40, 25, 25)
        textDay.border = BorderFactory.createEtchedBorder()
        textMonth.bounds = Rectangle(130, 40, 25, 25)
        textMonth.border = BorderFactory.createEtchedBorder()
        textYear.bounds = Rectangle(160, 40, 50, 25)
        textYear.border = BorderFactory.createEtchedBorder()
        if (phonebook.getPersonDateOfBirth(person).isNotEmpty()) {
            textDay.text = phonebook.getPersonDateOfBirth(person)[0].day.toString()
            textMonth.text = phonebook.getPersonDateOfBirth(person)[0].month.toString()
            textYear.text = phonebook.getPersonDateOfBirth(person)[0].year.toString()
        }
        add(textDay)
        add(textMonth)
        add(textYear)
    }

    private fun buildButtons() {
        val buttonSave = JButton("SAVE")
        buttonSave.actionCommand = AddDialog.SAVE
        buttonSave.addActionListener(this)
        buttonSave.bounds = Rectangle(10, 260, 205, 30)
        add(buttonSave)

        val buttonCancel = JButton("CANCEL")
        buttonCancel.actionCommand = AddDialog.CANCEL
        buttonCancel.addActionListener(this)
        buttonCancel.bounds = Rectangle(210, 260, 205, 30)
        add(buttonCancel)
    }

    override fun actionPerformed(actionEvent: ActionEvent) {
        val action = actionEvent.actionCommand
        isSave = SAVE == action
        isVisible = false
    }

    companion object {
        const val SAVE = "SAVE"
    }

    fun changeInfo(phonebook: ContactService, columnButton: MutableList<JButton>, i: Int) {

        if ((textFirstName.text != "" || textLastName.text != "") && (textFirstName.text != person.firstName || textLastName.text != person.lastName)) {
            val listOfContact = phonebook.getPersonContacts(person)
            person.firstName = textFirstName.text
            person.lastName = textLastName.text
            if (listOfContact.isNotEmpty()) {
                for (j in listOfContact)
                    phonebook.addContact(person, j)
            }
            columnButton[i].text = textFirstName.text + " " + textLastName.text
        }

        if (phonebook.getPersonDateOfBirth(person).isNotEmpty()) {
            phonebook.getPersonDateOfBirth(person)[0].day = textDay.text.toInt()
            phonebook.getPersonDateOfBirth(person)[0].month = textMonth.text.toInt()
            phonebook.getPersonDateOfBirth(person)[0].year = textYear.text.toInt()
        } else {
            if (textDay.text != "" || textMonth.text != "" || textYear.text != "") {
                val newBirthDay =
                    Contact.DateOfBirth(textDay.text.toInt(), textMonth.text.toInt(), textYear.text.toInt())
                phonebook.addContact(person, newBirthDay)
            }
        }

        if (phonebook.getPersonAddress(person).isNotEmpty()) {
            phonebook.getPersonAddress(person)[0].index = textIndex.text
            phonebook.getPersonAddress(person)[0].city = textCity.text
            phonebook.getPersonAddress(person)[0].street = textStreet.text
            phonebook.getPersonAddress(person)[0].house = textHouse.text
        } else {
            if (textIndex.text != "" || textCity.text != "" || textHouse.text != "" || textStreet.text != "") {
                val newAddress = Contact.Address(textIndex.text, textCity.text, textStreet.text, textHouse.text)
                phonebook.addContact(person, newAddress)
            }
        }

        if (phonebook.getPersonPhones(person).isNotEmpty()) {
            if (phonebook.getPersonPhones(person).size == 1) {
                if (textPhone.text == "" && textOtherPhone.text == "") {
                    phonebook.removeContact(person, phonebook.getPersonPhones(person)[0])
                } else if (textPhone.text != "" && textOtherPhone.text != "") {
                    phonebook.getPersonPhones(person)[0].number = textPhone.text
                    val newPhone = Contact.Phone(textOtherPhone.text)
                    phonebook.addContact(person, newPhone)
                } else {
                    if (textPhone.text != "") phonebook.getPersonPhones(person)[0].number = textPhone.text
                    if (textOtherPhone.text != "") phonebook.getPersonPhones(person)[0].number = textOtherPhone.text
                }
            } else {
                if (textPhone.text == "") {
                    phonebook.removeContact(person, phonebook.getPersonPhones(person)[0])
                } else {
                    phonebook.getPersonPhones(person)[0].number = textPhone.text
                }

                if (textOtherPhone.text == "") {
                    if (textPhone.text == "") {
                        phonebook.removeContact(person, phonebook.getPersonPhones(person)[0])
                    } else phonebook.removeContact(person, phonebook.getPersonPhones(person)[1])
                } else {
                    if (textPhone.text == "") {
                        phonebook.getPersonPhones(person)[0].number = textOtherPhone.text
                    } else phonebook.getPersonPhones(person)[1].number = textOtherPhone.text
                }
            }
        } else {
            if (textPhone.text != "" || textOtherPhone.text == "") {
                val newPhone = Contact.Phone(textPhone.text)
                phonebook.addContact(person, newPhone)
            } else if (textPhone.text == "" || textOtherPhone.text != "") {
                val newPhone = Contact.Phone(textOtherPhone.text)
                phonebook.addContact(person, newPhone)
            } else if (textPhone.text != "" || textOtherPhone.text != "") {
                val newPhone1 = Contact.Phone(textPhone.text)
                val newPhone2 = Contact.Phone(textOtherPhone.text)
                phonebook.addContact(person, newPhone1)
                phonebook.addContact(person, newPhone2)
            }
        }

        if (phonebook.getPersonEmails(person).isNotEmpty()) {
            if (phonebook.getPersonEmails(person).size == 1) {
                if (textEmail.text == "" && textOtherEmail.text == "") {
                    phonebook.removeContact(person, phonebook.getPersonEmails(person)[0])
                } else if (textEmail.text != "" && textOtherEmail.text != "") {
                    phonebook.getPersonEmails(person)[0].email = textEmail.text
                    val newEmail = Contact.Email(textOtherEmail.text)
                    phonebook.addContact(person, newEmail)
                } else {
                    if (textEmail.text != "") phonebook.getPersonEmails(person)[0].email = textEmail.text
                    if (textOtherEmail.text != "") phonebook.getPersonEmails(person)[0].email = textOtherEmail.text
                }
            } else {
                if (textEmail.text == "") {
                    phonebook.removeContact(person, phonebook.getPersonEmails(person)[0])
                } else {
                    phonebook.getPersonEmails(person)[0].email = textEmail.text
                }

                if (textOtherEmail.text == "") {
                    phonebook.removeContact(person, phonebook.getPersonEmails(person)[1])
                } else {
                    phonebook.getPersonEmails(person)[1].email = textOtherEmail.text
                }
            }
        } else {
            if (textEmail.text != "" || textOtherEmail.text == "") {
                val newEmail = Contact.Email(textEmail.text)
                phonebook.addContact(person, newEmail)
            } else if (textEmail.text == "" || textOtherEmail.text != "") {
                val newEmail = Contact.Email(textOtherEmail.text)
                phonebook.addContact(person, newEmail)
            } else if (textEmail.text != "" || textOtherEmail.text != "") {
                val newEmail1 = Contact.Email(textEmail.text)
                val newEmail2 = Contact.Email(textOtherEmail.text)
                phonebook.addContact(person, newEmail1)
                phonebook.addContact(person, newEmail2)
            }
        }
    }
}