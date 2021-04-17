package com.anupras.apl.tddmvvmsample.data.remote.response

/**
 * Created by Anamika Painuly on 17/04/21.
 */
class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)