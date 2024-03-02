package edu.psu.sweng888.p3;

import android.provider.BaseColumns;

public final class ProductContract {
    // To prevent someone from accidentally instantiating the contract class, make the constructor private.
    private ProductContract() {}

    /* Inner class that defines the table contents */
    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "products";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_SELLER = "seller";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_PICTURE = "picture";
    }
}

