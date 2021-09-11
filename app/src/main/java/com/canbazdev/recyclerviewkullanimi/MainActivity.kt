package com.canbazdev.recyclerviewkullanimi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.canbazdev.recyclerviewkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var studentList: ArrayList<Student>
    private lateinit var student1: Student
    private lateinit var student2: Student
    private lateinit var student3: Student
    private lateinit var student4: Student
    private lateinit var student5: Student

    private lateinit var teacherList: ArrayList<Teacher>

    private lateinit var teacher1: Teacher
    private lateinit var teacher2: Teacher
    private lateinit var teacher3: Teacher
    private lateinit var teacher4: Teacher
    private lateinit var teacher5: Teacher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        student1 = Student(name = "Hamza", 19011035, 1)
        student2 = Student(name = "Sena", 19011125, 2)
        student3 = Student(name = "Cagri", 19011081, 4)
        student4 = Student(name = "Ahmet", 19011066, 2)
        student5 = Student(name = "Yaren", 19011435, 2)

        teacher1 = Teacher(name = "Selin", "Math", 29)
        teacher2 = Teacher(name = "Gokhan", "Kekod", 31)
        teacher3 = Teacher(name = "Yusuf", "Physics", 53)
        teacher4 = Teacher(name = "Pelin", "Statistics", 44)
        teacher5 = Teacher(name = "Nur", "Discrete Math", 26)

        studentList = arrayListOf(
            student1,
            student2,
            student3,
            student4,
            student5,
        )
        teacherList = arrayListOf(
            teacher1,
            teacher2,
            teacher3,
            teacher4,
            teacher5,
        )

        val personAdapter = PersonAdapter(studentList, teacherList)
        binding.adapter = personAdapter

    }
}