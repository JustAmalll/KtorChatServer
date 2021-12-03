package dev.amal.data

import dev.amal.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    db: CoroutineDatabase
) : MessageDataSource {

    private val messages = db.getCollection<Message>()

    override suspend fun getAllMessages(): List<Message> =
        messages.find()
            .descendingSort(Message::timestamp)
            .toList()

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}