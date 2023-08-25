package com.example.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.noteapp.feature_note.domain.util.NoteOrder
import com.example.noteapp.feature_note.domain.util.OrderType
import com.example.noteapp.feature_note.presentation.notes.NotesEvent

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange:(NoteOrder) -> Unit
) {
    Column(

        modifier = modifier

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected =  noteOrder is NoteOrder.Title,
                onClick = { onOrderChange(NoteOrder.Title(noteOrder.orderType))}
            )
            Text(
                text = "Title"
            )
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected =  noteOrder is NoteOrder.Date,
                onClick = { onOrderChange(NoteOrder.Date(noteOrder.orderType))}
            )
            Text(
                text = "Date"
            )
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected =  noteOrder is NoteOrder.Color,
                onClick = { onOrderChange(NoteOrder.Color(noteOrder.orderType))}
            )
            Text(
                text = "Color"
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected =  noteOrder.orderType is OrderType.Ascending,
                onClick = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }

            )
            Text(
                text = "Ascending"
            )
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
            selected =  noteOrder.orderType is OrderType.Descending,
            onClick = {
                onOrderChange(noteOrder.copy(OrderType.Descending))}
            )
            Text(
                text = "Descending"
            )

        }
    }

}