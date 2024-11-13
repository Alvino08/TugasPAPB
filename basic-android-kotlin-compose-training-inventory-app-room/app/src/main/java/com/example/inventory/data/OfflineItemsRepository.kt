/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    //Mengambil semua item dalam bentuk Flow<List<Item>> dari itemDao.getAllItems(),
    // memungkinkan pemantauan data secara real-time.
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    //Mengambil item tertentu berdasarkan id dalam bentuk Flow<Item?>,
    // memungkinkan pemantauan data real-time pada item tersebut.
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    //Menyisipkan item baru ke dalam database secara asinkron dengan memanggil itemDao.insert(item).
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    //  Menghapus item dari database secara asinkron dengan memanggil itemDao.delete(item).
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    //Memperbarui data item di database secara asinkron dengan memanggil itemDao.update(item).
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
