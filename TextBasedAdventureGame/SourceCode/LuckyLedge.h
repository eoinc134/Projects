#ifndef LUCKYLEDGE_H
#define LUCKYLEDGE_H
#include <iostream>
#include <string>
using namespace std;


class LuckyLedge{

    private:
        int count;
    public:
        LuckyLedge();
        string tradeItem();
        bool winner();
        int getCount();

        friend class mainwindow;
};
#endif // LUCKYLEDGE_H
