package com.freshworks.giphy.repository

import androidx.lifecycle.LiveData
import com.freshworks.giphy.repository.api.GiphyAPI
import com.freshworks.giphy.repository.db.Favorite
import com.freshworks.giphy.repository.db.FavoriteDao
import com.freshworks.giphy.repository.entities.Response
import com.freshworks.giphy.repository.model.GiphyModel
import io.reactivex.Single

class GiphyRepository(private val giphyAPI: GiphyAPI, private val favoriteDao: FavoriteDao) {
    fun searchGifs(query: String): Single<Response.GiphyData> {
        return (if(query == "") giphyAPI.getTrendingGifs() else giphyAPI.searchGifs(query = query))
            .zipWith(
                favoriteDao.getAllFavIds(),
                {
                        giphyData: Response.GiphyData, favIds: List<String> -> applyFavorites(giphyData, favIds)
                }
            )
    }

    private fun applyFavorites(giphyData: Response.GiphyData, favIds: List<String>): Response.GiphyData {
        giphyData.giphyList.forEach {
            it.isFavorite = favIds.contains(it.id)
        }

        return giphyData
    }

    fun getFavoriteGifs(): LiveData<List<Favorite>> {
        return favoriteDao.getFavoriteGifs()
    }

    fun insertFavoriteGif(item: GiphyModel) {
        favoriteDao.insert(Favorite(null, item.id, item.title, item.path))
    }

    fun removeFavoriteGif(id:String) {
        favoriteDao.delete(id)
    }
}