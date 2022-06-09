package gui

import dataBase.ContactService
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class InformationDialog constructor(phonebook : ContactService, columnButton: MutableList<JButton>, i: Int) : JDialog(),
    ActionListener {
    init {
        buildInformationDialog(phonebook, columnButton,i)
    }

    private fun buildButtons(phonebook : ContactService, columnButton: MutableList<JButton>, i: Int) {
        val buttonDelete = JButton("DELETE")
        buttonDelete.addActionListener {
            columnButton[i].parent.remove(columnButton[i])
            //contactNote.removePerson(contactNote.getAllPeople()[i])
            revalidate()
            repaint()
            isVisible = false
        }
        buttonDelete.bounds = Rectangle(10, 225, 140, 30)
        add(buttonDelete)

        val buttonEdit = JButton("EDIT")
        buttonEdit.addActionListener {
            val editDialog = EditDialog(phonebook, i)
            if (editDialog.isSave){
                editDialog.changeInfo(phonebook, columnButton, i)
                dialogInit()
                buildInformationDialog(phonebook, columnButton, i)
                isVisible = true
            }
        }
        buttonEdit.bounds = Rectangle(140, 225, 140, 30)
        add(buttonEdit)

        val buttonCancel = JButton("CANCEL")
        buttonCancel.actionCommand = CANCEL
        buttonCancel.addActionListener(this)
        buttonCancel.bounds = Rectangle(280, 225, 140, 30)
        add(buttonCancel)
    }

    private fun buildInformationDialog(phonebook : ContactService, columnButton: MutableList<JButton>, i: Int){
       layout = null
       //Full name
       title = "VCard"
       val labelName = JLabel("Full name:          " + phonebook.getAllPeople()[i].toString())
       labelName.horizontalAlignment = SwingConstants.LEFT
       labelName.bounds = Rectangle(10, 10, 300, 25)
       add(labelName)
       //Date of birth
       val labelDateOfBirth = JLabel("Date of birth:     ")
       if (phonebook.getPersonDateOfBirth(phonebook.getAllPeople()[i]).isNotEmpty()){
           labelDateOfBirth.text = labelDateOfBirth.text + phonebook.getPersonDateOfBirth(phonebook.getAllPeople()[i])[0].toString()
       }
       else{
           labelDateOfBirth.text += "N/I"
       }
       labelDateOfBirth.horizontalAlignment = SwingConstants.LEFT
       labelDateOfBirth.bounds = Rectangle(10, 40, 300, 25)
       add(labelDateOfBirth)
       //Phone
       val labelPhone = JLabel("Phone:                ")
       if (phonebook.getPersonPhones(phonebook.getAllPeople()[i]).isNotEmpty()){
           labelPhone.text = labelPhone.text + phonebook.getPersonPhones(phonebook.getAllPeople()[i])[0].toString()
       }
       else{
           labelPhone.text += "N/I"
       }
       labelPhone.horizontalAlignment = SwingConstants.LEFT
       labelPhone.bounds = Rectangle(10, 70, 300, 25)
       add(labelPhone)
       //Other phone
       val labelOtherNumber = JLabel("Other phone:     ")
       if (phonebook.getPersonPhones(phonebook.getAllPeople()[i]).size > 1){
           labelOtherNumber.text = labelOtherNumber.text + phonebook.getPersonPhones(phonebook.getAllPeople()[i])[1].toString()
       }
       else{
           labelOtherNumber.text += "N/I"
       }
       labelOtherNumber.horizontalAlignment = SwingConstants.LEFT
       labelOtherNumber.bounds = Rectangle(10, 100, 300, 25)
       add(labelOtherNumber)
       //Email
       val labelEmail = JLabel("Email:                  ")
       if (phonebook.getPersonEmails(phonebook.getAllPeople()[i]).isNotEmpty()){
           labelEmail.text = labelEmail.text + phonebook.getPersonEmails(phonebook.getAllPeople()[i])[0].toString()
       }
       else{
           labelEmail.text += "N/I"
       }
       labelEmail.horizontalAlignment = SwingConstants.LEFT
       labelEmail.bounds = Rectangle(10, 130, 300, 25)
       add(labelEmail)
       //Other email
       val labelOtherEmail = JLabel("Other email:      ")
       if (phonebook.getPersonEmails(phonebook.getAllPeople()[i]).size > 1){
           labelOtherEmail.text = labelOtherEmail.text + phonebook.getPersonEmails(phonebook.getAllPeople()[i])[1].toString()
       }
       else{
           labelOtherEmail.text += "N/I"
       }
       labelOtherEmail.horizontalAlignment = SwingConstants.LEFT
       labelOtherEmail.bounds = Rectangle(10, 160, 300, 25)
       add(labelOtherEmail)
       //Address
       val labelAddress = JLabel("Address:            ")
       if(phonebook.getPersonAddress(phonebook.getAllPeople()[i]).isNotEmpty()) {
           labelAddress.text = labelAddress.text + phonebook.getPersonAddress(phonebook.getAllPeople()[i])[0].toString()
       }
       else{
           labelAddress.text += "N/I"
       }
       labelAddress.horizontalAlignment = SwingConstants.LEFT
       labelAddress.bounds = Rectangle(10, 190, 300, 25)
       add(labelAddress)


       buildButtons(phonebook, columnButton, i)
       isModal = true
       isResizable = false
       setBounds(0, 0, 450, 305)
       isVisible = true
   }

    override fun actionPerformed(actionEvent: ActionEvent) {
        isVisible = false
    }

    companion object {
        const val CANCEL = "CANCEL"
    }
}