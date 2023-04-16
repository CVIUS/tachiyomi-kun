package tachiyomi.domain.history.model

import tachiyomi.domain.manga.model.MangaCover
import java.util.Date

data class HistoryWithRelations(
    val id: Long,
    val chapterId: Long,
    val mangaId: Long,
    val title: String,
    val chapterNumber: Float,
    val chapterName: String,
    val readAt: Date?,
    val readDuration: Long,
    val coverData: MangaCover,
)
