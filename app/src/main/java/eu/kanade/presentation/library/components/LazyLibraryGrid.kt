package eu.kanade.presentation.library.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tachiyomi.domain.library.model.LibraryDisplayMode
import tachiyomi.domain.library.model.LibrarySort
import tachiyomi.presentation.core.components.FastScrollLazyVerticalGrid
import tachiyomi.presentation.core.util.plus

@Composable
fun LazyLibraryGrid(
    modifier: Modifier = Modifier,
    columns: Int,
    contentPadding: PaddingValues,
    content: LazyGridScope.() -> Unit,
) {
    FastScrollLazyVerticalGrid(
        columns = if (columns == 0) GridCells.Adaptive(128.dp) else GridCells.Fixed(columns),
        modifier = modifier,
        contentPadding = contentPadding + PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(CommonMangaItemDefaults.GridVerticalSpacer),
        horizontalArrangement = Arrangement.spacedBy(CommonMangaItemDefaults.GridHorizontalSpacer),
        content = content,
    )
}

fun LazyGridScope.globalSearchItem(
    searchQuery: String?,
    onGlobalSearchClicked: () -> Unit,
) {
    if (!searchQuery.isNullOrEmpty()) {
        item(
            span = { GridItemSpan(maxLineSpan) },
            contentType = { "library_global_search_item" },
        ) {
            GlobalSearchItem(
                searchQuery = searchQuery,
                onClick = onGlobalSearchClicked,
            )
        }
    }
}

fun LazyGridScope.headerItem(
    sort: LibrarySort,
    displayMode: LibraryDisplayMode,
    onClickOpenSortSheet: () -> Unit,
    onClickOpenRandomManga: () -> Unit,
    onChangeDisplayMode: (LibraryDisplayMode) -> Unit,
) {
    item(
        span = { GridItemSpan(maxLineSpan) },
        contentType = { "library_global_search_item" },
    ) {
        LibraryHeaderItem(
            sort = sort,
            displayMode = displayMode,
            onClickOpenSortSheet = onClickOpenSortSheet,
            onClickOpenRandomManga = onClickOpenRandomManga,
            onChangeDisplayMode = onChangeDisplayMode,
        )
    }
}
