#ifndef SHOP_H
#define SHOP_H

#include "Item.h"
#include <vector>

class Shop{
    private:
        static vector<Item> stock;

    public:
        Shop();
        string showStock();
        bool hasItem(string item);
        Item buyItem(string item);
        void removeItem(string item);
};

#endif // SHOP_H
