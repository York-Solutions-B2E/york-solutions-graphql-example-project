import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from "apollo-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'graphql-example-angular-frontend';

  accounts = null;
  error = null;

  constructor(private apollo: Apollo) {
  }

  ngOnInit() {
    console.log('init')
    this.apollo.watchQuery({
      query: gql`
        {
          accounts: getAccounts {
            id
            firstName,
            lastName
          }
        }
      `,
    }).valueChanges.subscribe((result: any) => {
      console.log(result)
      this.accounts = result?.data?.accounts;
      this.error = result.error;
    });
  }
}
