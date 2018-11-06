package com.android.providers.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.EthereumAccountAddress;

import com.android.providers.contacts.aggregation.AbstractContactAggregator;


/**
 * Handler for [Ethereum Account Address] data rows.
 */
public class DataRowHandlerForEthereumAccountAddress extends DataRowHandler {

    public DataRowHandlerForEthereumAccountAddress(Context context,
                                                   ContactsDatabaseHelper dbHelper,
                                                   AbstractContactAggregator aggregator) {
        super(context, dbHelper, aggregator, EthereumAccountAddress.CONTENT_ITEM_TYPE);
    }

    @Override
    public boolean hasSearchableData() {
        return true;
    }

    @Override
    public boolean containsSearchableColumns(ContentValues values) {
        return values.containsKey(EthereumAccountAddress.ADDRESS);
    }

    @Override
    public void appendSearchableData(SearchIndexManager.IndexBuilder builder) {
        builder.appendContentFromColumn(EthereumAccountAddress.ADDRESS);
    }
}
