#include "LuckyLedge.h"
#include "Player.h"

LuckyLedge::LuckyLedge(){
    this->count = 0;
}


string LuckyLedge::tradeItem(){
    string coinReturn[4] = {"cherry", "joker", "martian", "jester"};
    string out;
    string output[4];

    for (int i =0; i <= 3; i++) {
        int r = (rand() % 4);
        output[i] = (*(coinReturn+r));
        if(output[i].compare("cherry") == 0) {
            this->count++;
        }
    }

    for (int i =0; i <= 3; i++) {
        out += "\t " +(*(output+i)) ;
    }
    return out;
}


bool LuckyLedge::winner(){
    if (count > 0){
        return true;
    }
    return false;
}

int LuckyLedge::getCount(){
    return this->count;
}
