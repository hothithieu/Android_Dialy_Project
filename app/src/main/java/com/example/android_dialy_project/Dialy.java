package com.example.android_dialy_project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class Dialy {

        @PrimaryKey(autoGenerate = true)
        public int id;
        public String Title;
        public String Content;


        public Dialy(String Title, String Content) {
            this.Title = Title;
            this.Content = Content;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String tile) {
            Title = Title;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }
    }
