import { Message } from '@stomp/stompjs';
import { MessagingService } from './../shared-services/messaging.service';
import { Component, OnInit, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-real-time-chart',
  templateUrl: './real-time-chart.component.html',
  styleUrls: ['./real-time-chart.component.css']
})
export class RealTimeChartComponent implements OnInit, AfterViewInit {
  messageHistory = [];
  state: string = 'NOT CONNECTED';
  @ViewChild('realTimeChart', { static: false })
  canvas: ElementRef
  myChart

  constructor(private messageService: MessagingService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {

    /*
      SOCK JS implementation
    */
    this.messageService.initializeWebSocketConnection();
    this.messageService.realtimeSubject.subscribe((data: any) => {
      let activity = JSON.parse(data);
      plot.data.datasets[0].data.push(activity.value);
      plot.data.labels.push(activity.character)
      this.myChart.update();
    })
  
    let plot = {
      type: 'bar',
      data: {
        datasets: [{
          label: 'Number of Tweets',
          data: [],
          fill: false,
          borderColor: 'rgb(0,0,255)',
          backgroundColor: "white"
        }],
        labels: []
      },
      options: {
        elements: {
          line: {
            tension: 0 // disables bezier curves
          }
        },
        legend: {
          display: false
        },
        scales: {
          yAxes: [{
            ticks: {
              suggestedMin: 0,
              suggestedMax: 6
            }
          }]
        }
      }
    }
    this.myChart = new Chart(this.canvas.nativeElement, plot);

  }

}
