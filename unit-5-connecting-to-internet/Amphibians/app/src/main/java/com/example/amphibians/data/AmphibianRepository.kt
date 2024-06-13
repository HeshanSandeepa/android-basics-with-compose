package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianService

interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianRepository(private val amphibianService: AmphibianService): AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibianService.getAmphibians();
    }

}