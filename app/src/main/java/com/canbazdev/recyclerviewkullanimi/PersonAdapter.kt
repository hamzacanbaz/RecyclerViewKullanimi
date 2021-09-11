package com.canbazdev.recyclerviewkullanimi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canbazdev.recyclerviewkullanimi.databinding.RowItemStudentBinding
import com.canbazdev.recyclerviewkullanimi.databinding.RowItemTeacherBinding


class PersonAdapter(
    private val studentList: List<Student>,
    private val teacherList: List<Teacher>
) :
    RecyclerView.Adapter<PersonAdapter.BaseViewHolder<*>>() {

    companion object {
        private const val STUDENT = 0
        private const val TEACHER = 1
    }

    inner class StudentViewHolder(private val binding: RowItemStudentBinding) :
        BaseViewHolder<Student>(binding.root) {
        override fun bind(item: Student) {
            binding.studentInfo = item
        }

    }

    inner class TeacherViewHolder(private val binding: RowItemTeacherBinding) :
        BaseViewHolder<Teacher>(binding.root) {
        override fun bind(item: Teacher) {
            binding.teacherInfo = item
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            STUDENT -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RowItemStudentBinding.inflate(inflater, parent, false)
                StudentViewHolder(binding)
            }
            TEACHER -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RowItemTeacherBinding.inflate(inflater, parent, false)
                TeacherViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is StudentViewHolder -> holder.bind(studentList[position - studentList.size])
            is TeacherViewHolder -> holder.bind(teacherList[position])
            else -> throw IllegalArgumentException("Invalid person")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position < teacherList.size -> {
                TEACHER
            }
            (position - teacherList.size) < studentList.size -> {
                STUDENT
            }
            else -> {
                -1
            }
        }


    }

    override fun getItemCount() = studentList.size + teacherList.size

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }


}

