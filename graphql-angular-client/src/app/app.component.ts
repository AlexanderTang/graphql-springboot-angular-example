import {Component, OnInit} from '@angular/core';
import {Apollo} from 'apollo-angular';
import gql from 'graphql-tag';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'graphql-client';
  postsData: any;

  constructor(private apollo: Apollo){}

  // guidelines from https://www.apollographql.com/docs/angular/basics/setup/
  ngOnInit(): void {
    this.apollo.watchQuery({
      query: gql`
          {
              getPosts(authorId: "Stephen") {
                  title
              }
          }
      `
    }).valueChanges.subscribe(result => {
      this.postsData = result.data;
    });
  }
}
