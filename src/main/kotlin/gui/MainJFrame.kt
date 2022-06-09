package gui

import dataBase.ContactService
import dataBase.Person
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Dimension
import javax.swing.*

class MainJFrame constructor(phonebook : ContactService) : JFrame("Phonebook") {
    private val panel = JPanel()

    private val columnButton = mutableListOf<JButton>()

    init {
        buildMainFJame(phonebook)
    }

    private fun createButtonAdd(phonebook : ContactService): Component {
        var listPeople: List<Person>
        val panelButtonAdd = JPanel(BorderLayout(30, 450))
        val buttonAdd = JButton("+ADD")
        buttonAdd.horizontalAlignment = SwingConstants.RIGHT
        buttonAdd.addActionListener {
            val addDialog = AddDialog()
            if (addDialog.isSave) {
                if(addDialog.haveAdded(phonebook)){
                    listPeople = phonebook.getAllPeople()
                    val currentIndex = listPeople.size
                    val newButton = JButton(listPeople[currentIndex - 1].toString())
                    newButton.horizontalAlignment = SwingConstants.LEFT
                    columnButton.add(newButton)
                    newButton.maximumSize = Dimension(450, 30)
                    newButton.addActionListener {
                        val informationDialog = InformationDialog(phonebook, columnButton,currentIndex - 1)
                        informationDialog.revalidate()
                        informationDialog.repaint()
                        panel.revalidate()
                        panel.repaint()
                    }
                    panel.add(newButton)
                    panel.revalidate()
                    setSize(450, phonebook.getAllPeople().size * 30 + 60)
                    panel.repaint()
                }
            }
        }
        buttonAdd.maximumSize = Dimension(450, 30)
        panelButtonAdd.add(buttonAdd)
        return panelButtonAdd
    }

    private fun panelContacts(phonebook : ContactService): Component {

        val listPeople = phonebook.getAllPeople()

        for (i in listPeople.indices) {
            val buttonPanelContact = JButton(listPeople[i].toString())
            buttonPanelContact.horizontalAlignment = SwingConstants.LEFT
            columnButton.add(buttonPanelContact)
            columnButton[i].maximumSize = Dimension(450, 30)
            columnButton[i].addActionListener {
                InformationDialog(phonebook, columnButton,i)
            }
            panel.add(columnButton[i])
        }

        return panel
    }

    private fun buildMainFJame(phonebook : ContactService){
        frameInit()
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        setSize(450, phonebook.getAllPeople().size*30+60)
        defaultCloseOperation = EXIT_ON_CLOSE
        add(panelContacts(phonebook), BorderLayout.CENTER)
        panel.repaint()
        add(createButtonAdd(phonebook), BorderLayout.SOUTH)
        panel.repaint()
    }
}