const borrowCtx = document.getElementById('borrowChart').getContext('2d');

const trendsData = {
    'This Month': {
        labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
        borrows: [42, 38, 55, 48],
        returns: [35, 45, 40, 52]
    },
    'Last Month': {
        labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
        borrows: [50, 45, 38, 42],
        returns: [48, 40, 45, 38]
    },
    'Last 3 Months': {
        labels: ['Week 1-4', 'Week 5-8', 'Week 9-12'],
        borrows: [165, 180, 155],
        returns: [160, 170, 145]
    }
};

const borrowChart = new Chart(borrowCtx, {
    type: 'line',
    data: {
        labels: trendsData['This Month'].labels,
        datasets: [{
            label: 'Borrows',
            data: trendsData['This Month'].borrows,
            borderColor: '#4A90D9',
            backgroundColor: 'rgba(74, 144, 217, 0.1)',
            fill: true,
            tension: 0.4,
            pointRadius: 4,
            pointBackgroundColor: '#4A90D9'
        }, {
            label: 'Returns',
            data: trendsData['This Month'].returns,
            borderColor: '#10B981',
            backgroundColor: 'rgba(16, 185, 129, 0.1)',
            fill: true,
            tension: 0.4,
            pointRadius: 4,
            pointBackgroundColor: '#10B981'
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                position: 'top',
                align: 'end',
                labels: {
                    usePointStyle: true,
                    padding: 20
                }
            }
        },
        scales: {
            y: {
                beginAtZero: true,
                grid: {
                    color: '#E2E8F0'
                }
            },
            x: {
                grid: {
                    display: false
                }
            }
        }
    }
});

document.querySelector('.chart-select').addEventListener('change', function() {
    const selected = this.value;
    const data = trendsData[selected];
    borrowChart.data.labels = data.labels;
    borrowChart.data.datasets[0].data = data.borrows;
    borrowChart.data.datasets[1].data = data.returns;
    borrowChart.update();
});

const categoryCtx = document.getElementById('categoryChart').getContext('2d');
new Chart(categoryCtx, {
    type: 'doughnut',
    data: {
        labels: ['Programming', 'Science', 'Mathematics', 'History', 'Literature'],
        datasets: [{
            data: [35, 25, 20, 12, 8],
            backgroundColor: [
                '#4A90D9',
                '#10B981',
                '#F59E0B',
                '#7C3AED',
                '#EF4444'
            ],
            borderWidth: 0,
            hoverOffset: 10
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        cutout: '60%',
        plugins: {
            legend: {
                position: 'right',
                labels: {
                    usePointStyle: true,
                    padding: 15
                }
            }
        }
    }
});
