#ifndef STRINGINPUTCLI_H
#define STRINGINPUTCLI_H

#include "Command.h"
#include "ValidCommands.h"
#include <string>
#include <iostream>
#include <vector>
using namespace std;

class StringInputCLI{
    private:
        ValidCommands commands;

    public:
        StringInputCLI();
        Command getCommand();
        void showCommands();
};

#endif // STRINGINPUTCLI_H
