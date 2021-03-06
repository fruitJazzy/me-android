package io.forus.me.android.presentation.models.vouchers

import android.os.Parcel
import android.os.Parcelable
import io.forus.me.android.presentation.models.currency.Currency
import java.math.BigDecimal
import java.util.*

class Voucher(var isProduct: Boolean,
              var isUsed: Boolean,
              var address: String?,
              var name: String?,
              var organizationName: String?,
              var fundName: String?,
              var fundWebShopUrl: String?,
              var description: String?,
              var createdAt: Date?,
              var currency: Currency?,
              var amount: BigDecimal?,
              var logo: String?,
              var transactions: List<Transaction>,
              val product: Product? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString()?: "",
            parcel.readString()?: "",
            Date(parcel.readLong()),
            parcel.readParcelable(Currency::class.java.classLoader) ?: Currency(),
            BigDecimal.valueOf(parcel.readDouble()),
            parcel.readString() ?: "",
            parcel.createTypedArrayList(Transaction),
            parcel.readParcelable(Product::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (isProduct) 1 else 0)
        parcel.writeByte(if (isUsed) 1 else 0)
        parcel.writeString(address)
        parcel.writeString(name)
        parcel.writeString(organizationName)
        parcel.writeString(fundName)
        parcel.writeString(fundWebShopUrl)
        parcel.writeString(description)
        parcel.writeParcelable(currency, flags)
        parcel.writeString(logo)
        parcel.writeTypedList(transactions)
        parcel.writeParcelable(product, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Voucher> {
        override fun createFromParcel(parcel: Parcel): Voucher {
            return Voucher(parcel)
        }

        override fun newArray(size: Int): Array<Voucher?> {
            return arrayOfNulls(size)
        }
    }


}
