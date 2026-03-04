const activityCtx = document.getElementById('activityChart').getContext('2d');
new Chart(activityCtx, {
    type: 'line',
    data: {
        labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
        datasets: [{
            label: 'Borrows',
            data: [45, 52, 48, 61, 55, 32, 28],
            borderColor: '#4A90D9',
            backgroundColor: 'rgba(74, 144, 217, 0.1)',
            fill: true,
            tension: 0.4,
            pointRadius: 4,
            pointBackgroundColor: '#4A90D9'
        }, {
            label: 'Returns',
            data: [38, 45, 52, 48, 58, 28, 25],
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

const categoryCtx = document.getElementById('categoryChart').getContext('2d');
new Chart(categoryCtx, {
    type: 'bar',
    data: {
        labels: ['Programming', 'Science', 'Mathematics', 'History', 'Literature'],
        datasets: [{
            label: 'Books Borrowed',
            data: [423, 312, 256, 198, 167],
            backgroundColor: [
                '#4A90D9',
                '#10B981',
                '#F59E0B',
                '#7C3AED',
                '#EF4444'
            ],
            borderRadius: 8
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                display: false
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
