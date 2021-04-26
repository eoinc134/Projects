#ifndef STRINGINPUTGUI_H
#define STRINGINPUTGUI_H

#include "Command.h"
#include "ValidCommands.h"
#include <string>
#include <iostream>
#include <vector>
using namespace std;

class StringInputGUI{
    private:
        ValidCommands commands;

    public:
        StringInputGUI();
        Command getCommand(string, string);
        Command getCommand(string);
        Command getCommand();
        void showCommands();
};

#endif // StringInputGUI_H
