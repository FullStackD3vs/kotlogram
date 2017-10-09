package com.github.badoualy.telegram.tl.api.photos

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsPhoto
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLPhotoEmpty
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photos.photo#20212ca8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoto() : TLObject() {
    var photo: TLAbsPhoto = TLPhotoEmpty()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "photos.photo#20212ca8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(photo: TLAbsPhoto, users: TLObjectVector<TLAbsUser>) : this() {
        this.photo = photo
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(photo)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        photo = readTLObject<TLAbsPhoto>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += photo.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoto) return false
        if (other === this) return true

        return photo == other.photo
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x20212ca8.toInt()
    }
}