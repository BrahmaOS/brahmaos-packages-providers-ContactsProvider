package com.android.providers.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.BitcoinAccountAddress;

import com.android.providers.contacts.aggregation.AbstractContactAggregator;


/**
 * Handler for [Bitcoin Account Address] data rows.
 */
public class DataRowHandlerForBitcoinAccountAddress extends DataRowHandler {

    public DataRowHandlerForBitcoinAccountAddress(Context context,
                                                   ContactsDatabaseHelper dbHelper,
                                                   AbstractContactAggregator aggregator) {
        super(context, dbHelper, aggregator, BitcoinAccountAddress.CONTENT_ITEM_TYPE);
    }

    @Override
    public boolean hasSearchableData() {
        return true;
    }

    @Override
    public boolean containsSearchableColumns(ContentValues values) {
        return values.containsKey(BitcoinAccountAddress.ADDRESS);
    }

    @Override
    public void appendSearchableData(SearchIndexManager.IndexBuilder builder) {
        builder.appendContentFromColumn(BitcoinAccountAddress.ADDRESS);
    }
}
