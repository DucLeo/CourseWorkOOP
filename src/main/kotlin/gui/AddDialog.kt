package gui

import dataBase.Contact
import dataBase.ContactService
import dataBase.Person
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class AddDialog : JDialog(),
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


    var isSave = false
        private set

    init {
        layout = null
        title = "ADD CONTACT"
        buildFields()
        buildButtons()
        isModal = true
        isResizable = false
        setBounds(0, 0, 450, 340)
        isVisible = true
    }

    private fun buildFields() {

        val labelFirstName = JLabel("First name:")
        labelFirstName.horizontalAlignment = SwingConstants.LEFT
        labelFirstName.bounds = Rectangle(10, 10, 150, 25)
        add(labelFirstName)
        textFirstName.bounds = Rectangle(100, 10, 110, 25)
        textFirstName.border = BorderFactory.createEtchedBorder()
        add(textFirstName)


        val labelLastName = JLabel("Last name:")
        labelLastName.horizontalAlignment = SwingConstants.LEFT
        labelLastName.bounds = Rectangle(210, 10, 250, 25)
        add(labelLastName)
        textLastName.bounds = Rectangle(280, 10, 140, 25)
        textLastName.border = BorderFactory.createEtchedBorder()
        add(textLastName)


        val labelPhone = JLabel("Phone number:")
        labelPhone.horizontalAlignment = SwingConstants.LEFT
        labelPhone.bounds = Rectangle(10, 130, 430, 25)
        add(labelPhone)
        textPhone.bounds = Rectangle(100, 130, 320, 25)
        textPhone.border = BorderFactory.createEtchedBorder()
        add(textPhone)


        val labelOtherPhone = JLabel("Other number:")
        labelOtherPhone.horizontalAlignment = SwingConstants.LEFT
        labelOtherPhone.bounds = Rectangle(10, 160, 430, 25)
        add(labelOtherPhone)
        textOtherPhone.bounds = Rectangle(100, 160, 320, 25)
        textOtherPhone.border = BorderFactory.createEtchedBorder()
        add(textOtherPhone)


        val labelEmail = JLabel("Email:")
        labelEmail.horizontalAlignment = SwingConstants.LEFT
        labelEmail.bounds = Rectangle(10, 190, 430, 25)
        add(labelEmail)
        textEmail.bounds = Rectangle(100, 190, 320, 25)
        textEmail.border = BorderFactory.createEtchedBorder()
        add(textEmail)

        val labelOtherEmail = JLabel("Other email:")
        labelOtherEmail.horizontalAlignment = SwingConstants.LEFT
        labelOtherEmail.bounds = Rectangle(10, 220, 430, 25)
        add(labelOtherEmail)
        textOtherEmail.bounds = Rectangle(100, 220, 320, 25)
        textOtherEmail.border = BorderFactory.createEtchedBorder()
        add(textOtherEmail)


        val labelIndex = JLabel("Index:")
        labelIndex.horizontalAlignment = SwingConstants.LEFT
        labelIndex.bounds = Rectangle(10, 70, 150, 25)
        add(labelIndex)
        textIndex.bounds = Rectangle(100, 70, 110, 25)
        textIndex.border = BorderFactory.createEtchedBorder()
        add(textIndex)

        val labelCity = JLabel("City:")
        labelCity.horizontalAlignment = SwingConstants.LEFT
        labelCity.bounds = Rectangle(230, 70, 250, 25)
        add(labelCity)
        textCity.bounds = Rectangle(280, 70, 140, 25)
        textCity.border = BorderFactory.createEtchedBorder()
        add(textCity)

        val labelStreet = JLabel("Street:")
        labelStreet.horizontalAlignment = SwingConstants.LEFT
        labelStreet.bounds = Rectangle(10, 100, 150, 25)
        add(labelStreet)
        textStreet.bounds = Rectangle(100, 100, 110, 25)
        textStreet.border = BorderFactory.createEtchedBorder()
        add(textStreet)

        val labelHouse = JLabel("House:")
        labelHouse.horizontalAlignment = SwingConstants.LEFT
        labelHouse.bounds = Rectangle(230, 100, 300, 25)
        add(labelHouse)
        textHouse.bounds = Rectangle(280, 100, 140, 25)
        textHouse.border = BorderFactory.createEtchedBorder()
        add(textHouse)


        val labelBirthDay = JLabel("Date of birth:")
        labelBirthDay.horizontalAlignment = SwingConstants.LEFT
        labelBirthDay.bounds = Rectangle(10, 40, 250, 25)
        add(labelBirthDay)
        textDay.bounds = Rectangle(100, 40, 25, 25)
        textDay.border = BorderFactory.createEtchedBorder()
        add(textDay)
        textMonth.bounds = Rectangle(130, 40, 25, 25)
        textMonth.border = BorderFactory.createEtchedBorder()
        add(textMonth)
        textYear.bounds = Rectangle(160, 40, 50, 25)
        textYear.border = BorderFactory.createEtchedBorder()
        add(textYear)
    }


    private fun buildButtons() {
        val buttonSave = JButton("ADD NEW")
        buttonSave.actionCommand = SAVE
        buttonSave.addActionListener(this)
        buttonSave.bounds = Rectangle(10, 260, 205, 30)
        add(buttonSave)

        val buttonCancel = JButton("CANCEL")
        buttonCancel.actionCommand = CANCEL
        buttonCancel.addActionListener(this)
        buttonCancel.bounds = Rectangle(215, 260, 205, 30)
        add(buttonCancel)
    }


    fun haveAdded(phonebook : ContactService) : Boolean {
        var addedSuccess = false
        if ((textFirstName.text == "") or (textLastName.text == "")){
            val panel = JPanel()
            JOptionPane.showMessageDialog(panel, "Unable to create contact without first and last name!")
        }
        else {
            val person = Person(textFirstName.text, textLastName.text)
            if(phonebook.getAllPeople().contains(person)) {
                val panel = JPanel()
                JOptionPane.showMessageDialog(panel, "There is someone named $person in the phonebook!")
            }
            else {
                addedSuccess = true

                phonebook.addPerson(person)

                if (textPhone.text != "") {
                    phonebook.addContact(person, Contact.Phone(textPhone.text))
                }
                if (textOtherPhone.text != "") {
                    phonebook.addContact(person, Contact.Phone(textOtherPhone.text))
                }
                if (textEmail.text != "") {
                    phonebook.addContact(person, Contact.Email(textEmail.text))
                }
                if (textOtherEmail.text != "") {
                    phonebook.addContact(person, Contact.Email(textOtherEmail.text))
                }
                if ((textDay.text != "") or (textMonth.text != "") or (textYear.text != "")) {
                    phonebook.addContact(person, Contact.DateOfBirth(textDay.text.toInt(), textMonth.text.toInt(), textYear.text.toInt()))
                }
                if ((textIndex.text != "") and (textCity.text != "") and (textStreet.text != "") and (textHouse.text != "")) {
                    phonebook.addContact(person, Contact.Address(textIndex.text, textCity.text, textStreet.text, textHouse.text))
                }
            }
        }
        return addedSuccess
    }

    override fun actionPerformed(actonEvent: ActionEvent) {
        val action = actonEvent.actionCommand
        isSave = SAVE == action
        isVisible = false
    }

    companion object {
        const val SAVE = "SAVE"
        const val CANCEL = "CANCEL"
    }
}