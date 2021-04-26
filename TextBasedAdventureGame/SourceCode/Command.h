#ifndef COMMAND_H
#define COMMAND_H

#include <string>
using namespace std;

class Command{
    private:
        string firstWord;
        string secondWord;

    public:
        Command(string firstWord, string secondWord);

        string getFirstWord();
        string getSecondWord();
};

#endif // COMMAND_H
