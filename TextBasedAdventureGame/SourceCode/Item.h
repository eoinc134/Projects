#ifndef ITEM_H
#define ITEM_H

#include <string>
#include <iostream>
using namespace std;

class Item{
    private:
        string name, description;
        int value, weight;
        bool weapon, edible;

    public:
        Item(const Item &item);
        Item(string name, string description, int value, int weight, bool isWeapon, bool isEdible);

        string getItem();
        int getValue();
        void setValue(int value);
        int getWeight();
        bool isWeapon();
        bool isEdible();
        string examineItem();

        Item operator+(const Item& i);
        Item operator-(const Item& i);
};

#endif // ITEM_H
